import requests
from urllib.parse import urlparse

CHALLENGE_START = 'https://letsrevolutionizetesting.com/challenge.json'


def has_prop(prop, json):
    if prop in json:
        return True
    return False


def get_prop(prop, json):
    return json[prop]


def get_query_params(url):
    return urlparse(url).query


def fire_request(challenge_id=None):
    payload = {}
    json_response = {}
    message = None

    if (challenge_id):
        payload = {'id': challenge_id}

    # make request
    r = requests.get(CHALLENGE_START, payload)
    print(r.url)
    json_response = r.json()

#Continue to follow until something changes
    if (has_prop('follow', json_response)):
        follow = get_prop('follow', json_response)
        query_params = get_query_params(follow)
        new_id = query_params.split('=')[1]
        return fire_request(challenge_id=new_id)

#Something changed!
    elif has_prop('message', json_response):
        message = get_prop('message', json_response)
    return message


if __name__ == '__main__':
    print(fire_request(challenge_id=None))