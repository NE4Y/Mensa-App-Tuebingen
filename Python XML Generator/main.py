############################################
# Parser for mystuwe.de                    #
############################################
from webcrawler import WebCrawler
from stuweparser import StuweParser


crawler = WebCrawler("http://www.my-stuwe.de/mensa/mensa-morgenstelle-tuebingen")

parser = StuweParser(crawler.getHTML())

try:
	parser.generateXML()
except:
	print("An error occurrec while generating xml file")