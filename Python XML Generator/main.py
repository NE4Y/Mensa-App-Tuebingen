############################################
# Parser for mystuwe.de                    #
############################################
from webcrawler import WebCrawler
from stuweparser import StuweParser
from datetime import *

morgenstelle = "http://www.my-stuwe.de/mensa/mensa-morgenstelle-tuebingen"
wilhelm = "http://www.my-stuwe.de/mensa/mensa-wilhelmstrasse-tuebingen/"
alldays = "http://www.my-stuwe.de/mensa/mensa-morgenstelle-tuebingen/?woche="+str(datetime.today().isocalendar()[1])

crawler = WebCrawler(alldays)

parser = StuweParser(crawler.getHTML())

try:
	#parser.generateXML()
	parser.generateWeekXML()
	print("XML generated")
except Exception as e:
	print("An error occurred while generating xml file")
	print(e)