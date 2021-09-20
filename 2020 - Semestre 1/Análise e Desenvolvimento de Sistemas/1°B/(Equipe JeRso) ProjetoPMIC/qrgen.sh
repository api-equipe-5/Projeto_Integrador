while true
do
	var=$(tr -cd "[:digit:]" < /dev/urandom | head -c 6)
	qrencode --background=1994FAFF -o /var/www/html/qr.png $var
	mysql -u root -pSupersecreta2020 -D jersodb -e "UPDATE var_qr SET var_num = '$var' WHERE var_id =1"
	sleep 30
done
