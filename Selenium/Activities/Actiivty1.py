from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver (make sure chromedriver is installed)
driver = webdriver.Chrome()

# Open the training support site
driver.get("https://training-support.net")

# Print the title of the page
print("Home page title:", driver.title)

# Click the "About Us" button
about_us_link = driver.find_element(By.ID, "about-link")
about_us_link.click()

# Print the title of the new page
print("New page title:", driver.title)

# Close the browser
driver.quit()
