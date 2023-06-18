def get_float_input():
    while True:
        try:
            number = float(input("Введите дробное число: "))
            return number
        except ValueError:
            print("Ошибка: Введено некорректное значение. Пожалуйста, введите дробное число.")

# Пример использования метода
float_number = get_float_input()
print("Введенное число:", float_number)

