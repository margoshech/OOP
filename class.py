class StudentGroup:
    def __init__(self, group_id, students):
        self.group_id = group_id
        self.students = students

    def __str__(self):
        return f"Group ID: {self.group_id}, Students: {len(self.students)}"

    def __repr__(self):
        return str(self)


class StudentStream:
    def __init__(self, stream_id, groups):
        self.stream_id = stream_id
        self.groups = groups

    def __iter__(self):
        return iter(self.groups)

    def __str__(self):
        return f"Stream ID: {self.stream_id}, Groups: {len(self.groups)}"

    def __repr__(self):
        return str(self)


# Пример использования классов

# Создание групп студентов
group1 = StudentGroup("Group1", ["Student1", "Student2", "Student3"])
group2 = StudentGroup("Group2", ["Student4", "Student5"])
group3 = StudentGroup("Group3", ["Student6", "Student7", "Student8"])

# Создание потока студентов с группами
stream = StudentStream("Stream1", [group1, group2, group3])

# Итерация по группам в потоке и вывод на консоль
for group in stream:
    print(group)

# Сортировка групп в потоке по количеству студентов
sorted_groups = sorted(stream, key=lambda x: len(x.students))

# Вывод отсортированных групп на консоль
for group in sorted_groups:
    print(group)

