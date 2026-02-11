from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the alerts page
driver.get("https://training-support.net/webelements/alerts")

# Print the title of the page
print("Page title:", driver.title)

# Find the button to open a SIMPLE alert and click it
simple_alert_button = driver.find_element(By.ID, "simple")
simple_alert_button.click()

# Switch focus to the alert
simple_alert = driver.switch_to.alert

# Get the text in the alert and print it
print("Alert text:", simple_alert.text)

# Close the alert with OK
simple_alert.accept()

# Close the browser
driver.quit()
