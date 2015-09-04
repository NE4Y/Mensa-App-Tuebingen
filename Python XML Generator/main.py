############################################
# Parser for mystuwe.de                    #
############################################
from webcrawler import WebCrawler
from stuweparser import StuweParser
from datetime import *

morgenstelle = "http://www.my-stuwe.de/mensa/mensa-morgenstelle-tuebingen"
wilhelm = "http://www.my-stuwe.de/mensa/mensa-wilhelmstrasse-tuebingen/"
alldaysWillhelm = "http://www.my-stuwe.de/mensa/mensa-wilhelmstrasse-tuebingen/?woche="+str(datetime.today().isocalendar()[1] + 1)
alldays = "http://www.my-stuwe.de/mensa/mensa-morgenstelle-tuebingen/?woche="+str(datetime.today().isocalendar()[1] + 1)


print("Crawling: " + alldays)
crawler = WebCrawler(alldays)
print("Crawling: " + alldaysWillhelm)
crawler2 = WebCrawler(alldaysWillhelm)

print("Start xml generation")

parser = StuweParser(crawler.getHTML())
parser2 = StuweParser(crawler2.getHTML())

try:
	#parser.generateXML()
	parser.generateWeekXML("overviewMorgen.xml")
	parser2.generateWeekXML("overviewWillhelm.xml")
	print("XML generated")
except Exception as e:
	print("An error occurred while generating xml file")
	print(e)