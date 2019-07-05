# Web Query

An API exposing web pages are pure data (GraphQL + JSON)

## API

A simple API allows you to pull data from web pages with a simple query language.

To get all the stories from Hacker News

```
POST /api/v1/query \
-H 'Content-Type: application/json' \
-d '{"uri": "https://news.ycombinator.com", "query": ".storylink"}"'
```

Which will return 

```json
{
    "elements": [
        {
            "tag": "a",
            "text": "How the Dat Protocol Works",
            "attributes": {
                "href": "https://datprotocol.github.io/how-dat-works/",
                "class": "storylink"
            }
        },
        {
            "tag": "a",
            "text": "Bladder cancer 'attacked and killed by common cold virus'",
            "attributes": {
                "href": "https://www.bbc.com/news/health-48868261",
                "class": "storylink"
            }
        },
        ...
}
```
