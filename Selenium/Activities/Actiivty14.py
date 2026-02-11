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

# Print the Book Name in the 5th row
book_name_row5 = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[1]")
print("Book Name in 5th row:", book_name_row5.text)

# Click the header of the Price column to sort ascending
price_header = driver.find_element(By.XPATH, "//table/thead/tr/th[2]")
price_header.click()

# Print the Book Name in the 5th row again after sorting
book_name_row5_sorted = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[1]")
print("Book Name in 5th row after sorting:", book_name_row5_sorted.text)

# Close the browser
driver.quit()
