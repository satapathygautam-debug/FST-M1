from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

# Set up the driver
driver = webdriver.Chrome()
actions = ActionChains(driver)

# Open the mouse events page
driver.get("https://training-support.net/webelements/mouse-events")

# Print the title of the page
print("Page title:", driver.title)

# Left click on Cargo.lock, move to Cargo.toml and click
cargo_lock = driver.find_element(By.ID, "cargoLock")
cargo_toml = driver.find_element(By.ID, "cargoToml")
actions.click(cargo_lock).move_to_element(cargo_toml).click().perform()

# Print confirmation text
confirm1 = driver.find_element(By.ID, "result")
print("Confirmation after Cargo sequence:", confirm1.text)

# Double click on src button
src_button = driver.find_element(By.ID, "src")
actions.double_click(src_button).perform()

# Right click on target button and select "open"
target_button = driver.find_element(By.ID, "target")
actions.context_click(target_button).perform()
open_option = driver.find_element(By.ID, "open")
open_option.click()

# Print confirmation text
confirm2 = driver.find_element(By.ID, "result")
print("Confirmation after src/target sequence:", confirm2.text)

# Close the browser
driver.quit()
