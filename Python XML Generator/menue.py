##################################
#                                #
# Menüklasse für mystuwe.de      #
#                                #
##################################

class Menue:

	def __init__(self, name, food, costStudent, costPupil, costGuest):
		self.name = name
		self.food = food
		self.student = costStudent
		self.pupil = costPupil
		self.guest = costGuest

	def __str__(self):
		return self.name + ": " +  self.food + " Student: " + self.student

	