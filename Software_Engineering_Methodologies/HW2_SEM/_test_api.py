import requests
import json

"""
The app randomly pick a recipe, however, there is strict rule that the title of the 
webpage should contain some keywords, so I tested if these keywords are there
"""
def test_taco_app_basic():
    response = requests.get("http://taco-randomizer.herokuapp.com/")
    assert response
    assert response.status_code == 200
    assert response.headers['Content-Type'] == 'text/html; charset=utf-8'
    text = response.text
    assert 'taco' in text
    assert 'garnished with' in text
    assert 'topped off with' in text
    assert 'and wrapped in delicious' in text

"""
This API is to Get JSON formatted summary with title, description and preview image 
for any requested URL. I use this API to get data from google.com, I tested if the
returned format contains these attributes such as title, description, etc.
"""
def test_myjson_app_basic():
    url = 'https://www.google.com'
    response = requests.get("http://api.linkpreview.net/?key=123456&q=" + url)
    assert response
    assert response.status_code == 200
    assert response.headers['Content-Type'] == 'application/json; charset=utf-8'
    result = json.loads(response.text)
    assert type(result) is dict
    assert 'title' in result
    assert 'Google' in result['title']
    assert 'url' in result
    assert url in result['url']
    assert 'description' in result
    assert 'image' in result
    


    
    