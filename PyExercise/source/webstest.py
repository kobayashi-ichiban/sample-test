import requests
from bs4 import BeautifulSoup

url = "https://example.com"

r = requests.get(url)

soup = BeautifulSoup(r.content, "html.parser")

print(soup.select("h1"))

print(soup.select("p"))
