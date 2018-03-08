from selenium import webdriver
from selenium.webdriver.common.keys import Keys

browser = None

def setup_module(module):
    global browser
    browser = webdriver.Chrome()
    browser.get("http://www.amazon.com")

def teardown_module(module):
    if browser:
        browser.close()

def test_go_to_amazon():
    assert "Amazon" in browser.title

def test_is_Oster_a_displayed_blender():
    id1 = "twotabsearchtextbox"
    searchbox = browser.find_element_by_id(id1)
    searchbox.clear()
    searchbox.send_keys("blender")
    searchbox.send_keys(Keys.RETURN)
    id2 = "s-results-list-atf"
    result_list = browser.find_element_by_id(id2)
    assert "Oster" in result_list.text