import twilio
from twilio.rest import Client

# Twilio
# Saldo: $14.245
# Vlr x msj: $0.0525 (Aprox xd)

account_sid = 'AC18fa2e9feb4cf58ba8797e596c118a20'
auth_token = 'e9527bf498c24bd8c54cb62d605d8417'


client = Client(account_sid, auth_token)


message = client.messages.create(
    body='Este es un mensaje de prueba desde Twilio y Python.',
    from_='12679433060',
    to='573203414663'
)

print(message.sid)
