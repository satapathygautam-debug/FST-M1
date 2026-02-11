from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

# Set up the driver
driver = webdriver.Chrome()
actions = ActionChains(driver)

# Open the drag and drop page
driver.get("https://training-support.net/webelements/drag-drop")

# Print the title of the page
print("Page title:", driver.title)

# Find the ball
ball = driver.find_element(By.ID, "ball")

# Find Dropzone 1 and Dropzone 2
dropzone1 = driver.find_element(By.ID, "dropzone1")
dropzone2 = driver.find_element(By.ID, "dropzone2")

# Drag and drop the ball into Dropzone 1
actions.drag_and_drop(ball, dropzone1).perform()
print("Ball entered Dropzone 1:", dropzone1.text)

# Drag and drop the ball into Dropzone 2
actions.drag_and_drop(ball, dropzone2).perform()
print("Ball entered Dropzone 2:", dropzone2.text)

# Close the browser
driver.quit()
