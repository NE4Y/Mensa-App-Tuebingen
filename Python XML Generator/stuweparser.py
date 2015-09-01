###################################################
#                                                 #
#  HTML Parser for MyStuwe.de                     #
#                                                 #
###################################################
from bs4 import BeautifulSoup
from menue import Menue
from day import Day
import xml.etree.cElementTree as ET

class StuweParser:
	days = []

	def __init__(self, html):
		self.parser = BeautifulSoup(html, 'html.parser')

	# returns current day
	def getCurrentDay(self):
		return self.parser.find_all("span", class_="speiseplan2-wochentag")[0].string

	# returns current date
	def getCurrentDate(self):
		return self.parser.find_all("span", class_="speiseplan2-datum")[0].string

	# generates menues
	def getFoodTable(self):
		table = self.parser.table.find_all('tr')

		# remove information bar
		table.pop(0)

		menues = []

		for tr in table:
			tds = tr.find_all('td')
			menue = Menue(tds[0].string, tds[1].string, tds[2].string, tds[3].string)

			menues.append(menue)

		return menues

	# generates xml
	def generateXML(self):
		menues = self.getFoodTable()

		root = ET.Element("mensa")

		day = ET.SubElement(root, "day").text = self.getCurrentDay()
		date = ET.SubElement(root, "date").text = self.getCurrentDate()


		for m in menues:
			men = ET.SubElement(root, "menue")

			# menue name
			ET.SubElement(men, "name").text = m.name

			# food
			food = m.food.rstrip('\r\n').split('\n')
			food = [y for y in [x.lstrip() for x in food] if y != '']

			ET.SubElement(men, "food").text = ''.join(food)

			print(''.join(food))
			

			# student price
			ET.SubElement(men, "studentPrice").text = m.student

			# guest price
			ET.SubElement(men, "guestPrice").text = m.guest

		tree = ET.ElementTree(root)

		tree.write("actuallday.xml")

	# get all food information
	def getAllFoodInformation(self):
		menues = self.parser.find_all('table')

		for t in menues:
			self.getMenuesByDay(t, t.previous_element.string, t.previous_element.previous_element.previous_element.string)


	def getMenuesByDay(self, day, date, rday):
		day = day.find_all('tr')

		menues = []

		for tr in day:
			#print(tr)
			tds = tr.find_all('td')
			if(len(tds) > 3):
				menue = Menue(tds[0].string, tds[1].string, tds[2].string, tds[3].string)

				menues.append(menue)


		
		StuweParser.days.append(Day(rday, date, menues))

	def generateWeekXML(self):
		self.getAllFoodInformation()

		menues = self.getFoodTable()

		root = ET.Element("mensaXML")


		for d in StuweParser.days:

			subroot = ET.SubElement(root, "mensa")

			day = ET.SubElement(subroot, "day").text = d.day
			date = ET.SubElement(subroot, "date").text = d.date
			

			for m in d.menu:
				men = ET.SubElement(subroot, "menue")

				# menue name
				ET.SubElement(men, "name").text = m.name

				# food
				food = m.food.rstrip('\r\n').split('\n')
				food = [y for y in [x.lstrip() for x in food] if y != '']

				ET.SubElement(men, "food").text = ''.join(food)

				#print(''.join(food))
			

				# student price
				ET.SubElement(men, "studentPrice").text = m.student

				# guest price
				ET.SubElement(men, "guestPrice").text = m.guest

		tree = ET.ElementTree(root)

		tree.write("overview.xml")










