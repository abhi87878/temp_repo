import pytest
from selenium import webdriver

@pytest.fixture(scope="class")
def setup(request)
    print("===== Launching Chrome Browser =====")
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html")
    request.cls.driver = driver
    yield
    print("===== Closing Browser =====")
    driver.quit()
