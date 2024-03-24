class Problem1Registration:
    def main(self):
        username = input()
        
        while True:
            input_str = input()
            if input_str == "Registration":
                break

            info = input_str.split()
            command = info[0]

            if command == "Letters":
                direction = info[1]
                if direction == "Upper":
                    username = username.upper()
                elif direction == "Lower":
                    username = username.lower()
                print(username)

            elif command == "Reverse":
                start_index = int(info[1])
                end_index = int(info[2])
                if self.is_valid(start_index, username) and self.is_valid(end_index, username):
                    substring = username[start_index:end_index + 1][::-1]
                    print(substring)

            elif command == "Substring":
                text_to_remove = info[1]
                if text_to_remove in username:
                    username = username.replace(text_to_remove, "")
                    print(username)
                else:
                    print(f"The username {username} doesn't contain {text_to_remove}.")

            elif command == "Replace":
                char_to_replace = info[1]
                username = username.replace(char_to_replace, "-")
                print(username)

            elif command == "IsValid":
                char_to_check = info[1]
                if char_to_check in username:
                    print("Valid username.")
                else:
                    print(f"{char_to_check} must be contained in your username.")

    def is_valid(self, index, username):
        return 0 <= index < len(username)


if __name__ == "__main__":
    registration = Problem1Registration()
    registration.main()
