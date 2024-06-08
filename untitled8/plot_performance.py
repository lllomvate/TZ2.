import matplotlib.pyplot as plt

# Чтение данных из файла
data = []
with open("performance_data.txt") as file:
    for line in file:
        size, time = map(int, line.split())
        data.append((size, time))

# Разделение данных на размеры и времена
sizes, times = zip(*data)

# Построение графика
plt.figure(figsize=(10, 6))
plt.plot(sizes, times, marker='o')
plt.title('Зависимость времени выполнения функции _sum от количества чисел в файле')
plt.xlabel('Количество чисел')
plt.ylabel('Время выполнения (наносекунды)')
plt.grid(True)
plt.show()