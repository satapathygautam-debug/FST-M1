from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the keyboard events page
driver.get("https://training-support.net/webelements/keyboard-events")

# Print the title of the page
print("Page title:", driver.title)

# Find the input field
input_field = driver.find_element(By.ID, "keyboardInput")

# Type out a string
message = "Hello from Selenium Python!"
input_field.send_keys(message)

# Print the message to the console
print("Message typed:", message)

# Close the browser
driver.quit()
