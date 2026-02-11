from selenium import webdriver
from selenium.webdriver.common.by import By

# Set up the driver
driver = webdriver.Chrome()

# Open the tables page
driver.get("https://training-support.net/webelements/tables")

# Print the title of the page
print("Page title:", driver.title)

# Find number of rows
rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
print("Number of rows:", len(rows))

# Find number of columns
cols = driver.find_elements(By.XPATH, "//table/tbody/tr[1]/td")
print("Number of columns:", len(cols))

# Print all cell values in the third row
third_row = driver.find_elements(By.XPATH, "//table/tbody/tr[3]/td")
print("Third row values:")
for cell in third_row:
    print(cell.text)

# Print the cell value at second row, second column
cell_value = driver.find_element(By.XPATH, "//table/tbody/tr[2]/td[2]")
print("Second row, second column value:", cell_value.text)

# Close the browser
driver.quit()
