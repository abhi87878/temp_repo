from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class CheckboxPage:
    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)
        self.checkbox_locator = (By.XPATH, "//td[text()='Helen Bennett']/preceding-sibling::td/input")

    def click_helen_bennett_checkbox(self):
        checkbox = self.wait.until(EC.element_to_be_clickable(self.checkbox_locator))
        checkbox.click()
        print("===== Checkbox clicked for 'Helen Bennett' =====")
