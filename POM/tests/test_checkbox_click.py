import pytest
from pages.checkbox_page import CheckboxPage

@pytest.mark.usefixtures("setup")
class TestCheckboxClick:

    def test_click_checkbox_for_helen_bennett(self):
        print("===== Running test: Click checkbox for 'Helen Bennett' =====")
        checkbox_page = CheckboxPage(self.driver)
        checkbox_page.click_helen_bennett_checkbox()
        print("===== Test completed successfully =====")
