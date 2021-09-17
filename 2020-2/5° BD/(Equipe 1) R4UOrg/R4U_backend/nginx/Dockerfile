# Use the nginx image
FROM nginx

# Remove the default nginx.conf
RUN rm /etc/nginx/conf.d/default.conf

# Replace with our own nginx.conf
COPY nginx.conf /etc/nginx/conf.d

# Replace the  default index page
RUN rm /usr/share/nginx/html/index.html

# Replace with our own index.html
COPY index.html /usr/share/nginx/html/

#Run the nginx with new configurations
RUN service nginx restart