from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Set up the driver
driver = webdriver.Chrome()
wait = WebDriverWait(driver, 10)

# Open the dynamic content page
driver.get("https://training-support.net/webelements/dynamic-content")

# Print the title of the page
print("Page title:", driver.title)

# Find and click the "Click me!" button
click_me_button = driver.find_element(By.ID, "clickMe")
click_me_button.click()

# Wait until the word "release" appears
wait.until(EC.text_to_be_present_in_element((By.ID, "dynamicText"), "release"))

# Get the text and print it
text = driver.find_element(By.ID, "dynamicText").text
print("Message displayed:", text)

# Close the browser
driver.quit()
