
import random
import string
import sys
#password generator
def password_generator():
    #get the length of the password
    length = int(input("Enter the length of the password: "))
    #get the number of passwords
    num = int(input("How many passwords do you want to generate? "))
    #get the characters to be used
    chars = string.ascii_letters + string.digits + string.punctuation
    #generate the passwords
    for i in range(num):
        password = ""
        for j in range(length):
            password += random.choice(chars)
        print(password)
#main function
def main():
    password_generator()
#call the main function
if __name__ == "__main__":
    main()
    