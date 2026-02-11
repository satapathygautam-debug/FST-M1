from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

# Set up the driver
driver = webdriver.Chrome()

# Open the selects page
driver.get("https://training-support.net/webelements/selects")

# Print the title of the page
print("Page title:", driver.title)

# Find the Multi Select dropdown
multi_select_element = driver.find_element(By.ID, "multiSelect")
multi_select = Select(multi_select_element)

# Select the "HTML" option using visible text
multi_select.select_by_visible_text("HTML")

# Select the 4th, 5th, and 6th options using index (index starts at 0)
multi_select.select_by_index(3)
multi_select.select_by_index(4)
multi_select.select_by_index(5)

# Select the "Node" option using value
multi_select.select_by_value("node")

# Deselect the 5th option using index
multi_select.deselect_by_index(4)

# Close the browser
driver.quit()
