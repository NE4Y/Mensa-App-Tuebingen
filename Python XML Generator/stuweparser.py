###################################################
#                                                 #
#  HTML Parser for MyStuwe.de                     #
#                                                 #
###################################################
from bs4 import BeautifulSoup
from menue import Menue
import xml.etree.cElementTree as ET

class StuweParser:

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
			menue = Menue(tds[0].string, tds[1].string, tds[2].string, tds[3].string, tds[4].string)

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
			ET.SubElement(men, "food").text = m.food

			# student price
			ET.SubElement(men, "studentPrice").text = m.student

			# pupil price
			ET.SubElement(men, "pupilPrice").text = m.pupil

			# guest price
			ET.SubElement(men, "guestPrice").text = m.guest

		tree = ET.ElementTree(root)

		tree.write("mensa.xml")









