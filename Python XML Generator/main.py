############################################
# Parser for mystuwe.de                    #
############################################
from webcrawler import WebCrawler
from stuweparser import StuweParser


crawler = WebCrawler("http://www.my-stuwe.de/mensa/mensa-morgenstelle-tuebingen")

parser = StuweParser(crawler.getHTML())

try:
	parser.generateXML()
	print("XML generated")
except Exception as e:
	print("An error occurred while generating xml file")
	print(e)