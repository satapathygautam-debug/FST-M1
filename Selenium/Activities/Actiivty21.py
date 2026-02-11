from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the tabs page
driver.get("https://training-support.net/webelements/tabs")

# Print the title of the page
print("Page title:", driver.title)

# Find the button to open a new tab and click it
new_tab_button = driver.find_element(By.ID, "newTab")
new_tab_button.click()

# Wait for the new tab to open and print all handles
handles = driver.window_handles
print("Window handles:", handles)

# Switch to the newly opened tab
driver.switch_to.window(handles[-1])

# Print the new tab's title and message
print("New tab title:", driver.title)
message = driver.find_element(By.ID, "message")
print("Message on new tab:", message.text)

# Repeat: click the button in the new tab page
new_tab_button2 = driver.find_element(By.ID, "newTab")
new_tab_button2.click()

# Print all handles again
handles2 = driver.window_handles
print("Window handles after second tab:", handles2)

# Switch to the latest tab
driver.switch_to.window(handles2[-1])

# Print the latest tab's title and message
print("Latest tab title:", driver.title)
message2 = driver.find_element(By.ID, "message")
print("Message on latest tab:", message2.text)

# Close the browser
driver.quit()
