myip=$(curl ifconfig.me); 
curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer 2192ded49e6fe3e4884e85ec50b93e021ba61e331d9783475cddc8755dea5e0c" -d "{\"inbound_rules\": [{\"protocol\": \"tcp\",\"ports\": \"22\",\"sources\": {\"addresses\": [\"$myip\"]}}]}" "https://api.digitalocean.com/v2/firewalls/739a07c4-fd97-4a36-bb22-a5881c6de9aa/rules"
ssh someuser@165.227.41.115 "echo \"${myip}\" >> /var/lib/jenkins/whitelist" 
ssh someuser@165.227.41.115 'sudo /usr/bin/systemctl reload haproxy'
