from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the alerts page
driver.get("https://training-support.net/webelements/alerts")

# Print the title of the page
print("Page title:", driver.title)

# Find the button to open a CONFIRM alert and click it
confirm_alert_button = driver.find_element(By.ID, "confirm")
confirm_alert_button.click()

# Switch focus to the alert
confirm_alert = driver.switch_to.alert

# Get the text in the alert and print it
print("Alert text:", confirm_alert.text)

# Close the alert with OK
confirm_alert.accept()
print("Alert closed with OK.")

# Open the confirm alert again
confirm_alert_button.click()
confirm_alert = driver.switch_to.alert

# Print the text again
print("Alert text:", confirm_alert.text)

# Close the alert with Cancel
confirm_alert.dismiss()
print("Alert closed with Cancel.")

# Close the browser
driver.quit()
