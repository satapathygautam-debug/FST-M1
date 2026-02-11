from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the target practice page
driver.get("https://training-support.net/webelements/target-practice")

# Print the title of the page
print("Page title:", driver.title)

# Using XPath: Find the 3rd header and print its text
third_header = driver.find_element(By.XPATH, "//h3")
print("3rd header text:", third_header.text)

# Using XPath: Find the 5th header and print its color
fifth_header = driver.find_element(By.XPATH, "//h5")
print("5th header color:", fifth_header.value_of_css_property("color"))

# Using another locator: Find the purple button and print all its classes
purple_button = driver.find_element(By.CLASS_NAME, "purple")
print("Purple button classes:", purple_button.get_attribute("class"))

# Using another locator: Find the slate button and print its text
slate_button = driver.find_element(By.CLASS_NAME, "slate")
print("Slate button text:", slate_button.text)

# Close the browser
driver.quit()
