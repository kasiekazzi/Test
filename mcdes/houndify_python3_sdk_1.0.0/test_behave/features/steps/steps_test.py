from behave import given, when, then, use_step_matcher
import houndify


use_step_matcher("re")



@when('we implement a test 2')
def step_impl(context):
    CLIENT_ID = 'AohlGgQk7o3W5Kdr5Z6coQ=='
    CLIENT_KEY = 'q1_toJmHYXTf6GF51J45cUfnBeFWSoahLjPthENz5iMcmHuk51yij98ZMu1JA0qC4yQ6jtU3XDAU6zUdE63t2g=='
    QUERY = 'Tell me a joke.'

    requestInfo = {
        ## Pretend we're at SoundHound HQ.  Set other fields as appropriate
        'Latitude': 37.388309,
        'Longitude': -121.973968
    }

    client = houndify.TextHoundClient(CLIENT_ID, CLIENT_KEY, "test_user", requestInfo)

    response = client.query(QUERY)
    test=response['AllResults'][0]['CommandKind']
    print(response['AllResults'][0]['CommandKind'])
    assert True is False
    assert test in 'InformationCommand'
