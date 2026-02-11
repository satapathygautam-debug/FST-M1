from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the alerts page
driver.get("https://training-support.net/webelements/alerts")

# Print the title of the page
print("Page title:", driver.title)

# Find the button to open a PROMPT alert and click it
prompt_alert_button = driver.find_element(By.ID, "prompt")
prompt_alert_button.click()

# Switch focus to the alert
prompt_alert = driver.switch_to.alert

# Get the text in the alert and print it
print("Alert text:", prompt_alert.text)

# Type "Awesome!" into the prompt
prompt_alert.send_keys("Awesome!")

# Close the alert by clicking OK
prompt_alert.accept()

# Close the browser
driver.quit()
