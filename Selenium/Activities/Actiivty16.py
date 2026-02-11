from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

# Set up the driver
driver = webdriver.Chrome()

# Open the selects page
driver.get("https://training-support.net/webelements/selects")

# Print the title of the page
print("Page title:", driver.title)

# Find the Single Select dropdown
dropdown = driver.find_element(By.ID, "singleSelect")
select = Select(dropdown)

# Select the second option using visible text
select.select_by_visible_text("Option 2")

# Select the third option using index (index starts at 0)
select.select_by_index(2)

# Select the fourth option using value
select.select_by_value("4")

# Get all options and print them
options = select.options
print("Dropdown options:")
for option in options:
    print(option.text)

# Close the browser
driver.quit()
