from scrapy.spiders import CrawlSpider, Rule
from wikiSpyder.items import Article
from scrapy.linkextractors import LinkExtractor

class ArticleSpider(CrawlSpider):
    name="article"
    allowed_domains = ["en.wikipedia.org"]
    start_urls = ["http://en.wikipedia.org/wiki/Main_Page", 
        "http://en.wikipedia.org/wiki/Python_%28programming_language%29"]
    
    rules = [Rule(LinkExtractor(allow=('(/wiki/)((?!:).)*$'),), callback="parse_item", follow=True)]
        
    def parse_item(self, response):
        item = Article()
        title = response.xpath('//h1/text()')[0].extract()
        print("Title is: {}".format(title))
        item['title'] = title
        return item