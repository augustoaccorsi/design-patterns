'''
Obeserver Design pattern
'''

class User:
    '''
    User class will act role of observer to subject
    '''
    def __init__(self, name):
        self.name = name

    def update(self, article, blog_writer):
        print(f'For {self.name}, new article called {article} by {blog_writer.name} is added')

class BlogWriter:
    '''
    BlogWriter class is useful to blog writer to add new article
    and manage subscribers as well
    '''
    def __init__(self, name):
        self.name = name
        self.__subscribers = []
        self.__articles = []

    def add_article(self, article):
        '''
        Add new article and notify subscribers
        '''
        self.__articles.append(article)
        self.notify_subscribers(article)

    def get_articles(self):
        '''
        Get articles written by {self}
        '''
        return self.__articles

    def subscribe(self, subscriber):
        '''
        Add new subscriber to notify on adding article
        '''
        self.__subscribers.append(subscriber)

    def unsubscribe(self, subscriber):
        '''
        User can unsubscribe from further notifications
        '''
        return self.__subscribers.remove(subscriber)

    def subscribers(self):
        '''
        Get subsribers
        '''
        return self.__subscribers

    def notify_subscribers(self, article):
        '''
        Notifying all the subsribers about new addition of an article
        '''
        for sub in self.__subscribers:
            sub.update(article, self)

if __name__ == '__main__':
    blog_writer = BlogWriter('Desing Pattern\'s blog')
    guto = User('Guto')
    blog_writer.subscribe(guto)
    blog_writer.add_article('Observer Arcticle')

    
    blog_writer1 = BlogWriter('Geology\'s blog')
    daia = User('Daiana')
    blog_writer1.subscribe(daia)
    blog_writer1.add_article('New Dinosaur Fossils Discovered')