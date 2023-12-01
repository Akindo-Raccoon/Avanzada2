from nexmo import Sms

# Nexmo
# Saldo: $1.96
# Vlr x msj: $0.04

sms=Sms(key='6a81c822', secret='uiIjNAnw153SMilB')
sms.send_message({
            "from": "573203414663",
            "to": "573203414663",
            "text": "A text message sent using the Nexmo SMS API",
})