import requests

def keywordSearch(keyword):
	response = requests.get('https://www.amazon.com/s/ref=nb_sb_noss/140-4944800-3044647?url=search-alias%3Daps&field-keywords=' + keyword)
	print(response.content)
	assert 'Canon' in response.content.decode("utf-8")

keywordSearch('Professional Camera')