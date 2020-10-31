# TODO: Write documentation for `YourApp`
require "sendgrid"
require "dotenv"
Dotenv.load ".env"

module YourApp
  VERSION = "0.1.0"

  # TODO: Put your code here
  client = Sendgrid::Client.new("https://api.sendgrid.com/v3/mail/send", ENV["SENDGRID_API_KEY"])
  message = Sendgrid::Message.new
  message.to << Sendgrid::Address.new(email="stasbar1995@gmail.com", name="test@example.com")
  message.from = Sendgrid::Address.new(email="golden-nuggets@stasbar.com", name="Golden Nuggets")
  message.subject = "Sending with SendGrid is Fun"
  message.content = Sendgrid::Content.new(type: "text/plain", body: "and easy to do anywhere, even with Ruby")
  send = client.send message
  puts message.to_json
  puts send.status_code
  puts send.body
end
