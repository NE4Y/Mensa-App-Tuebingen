###################################################
#                                                 #
#  HTTP Crawler to get html from website          #
#                                                 #
###################################################
import urllib.request;

class WebCrawler:
	
	##################################
	# Init object with crawling url  #
	##################################
	def __init__(self, url):
		try:
			# headers for correct request
			hdr = {'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11',
       				'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
       				'Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3',
       				'Accept-Encoding': 'none',
       				'Accept-Language': 'en-US,en;q=0.8',
       				'Connection': 'keep-alive'}

			self.html = urllib.request.Request(url, headers=hdr)

			# fetch html
			with urllib.request.urlopen(self.html) as response:
   				self.html = response.read()

		except Exception as e:			
			print("An error occurred during HTML crawling.")

	##################################
	# Returns html for parser        #
	##################################
	def getHTML(self):
		return self.html
