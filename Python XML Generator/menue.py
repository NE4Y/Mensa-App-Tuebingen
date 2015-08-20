##################################
#                                #
# Menüklasse für mystuwe.de      #
#                                #
##################################

class Menue:

	def __init__(self, name, food, costStudent, costGuest):
		self.name = name
		self.food = food
		self.student = costStudent
		self.guest = costGuest

	def __str__(self):
		return self.name + ": " +  self.food + " Student: " + self.student

	