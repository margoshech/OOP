from typing import List

class StudentGroup:
    def __init__(self, group_id: int, students: List[str]):
        self.group_id = group_id
        self.students = students

    def __str__(self):
        return f"Group ID: {self.group_id}, Students: {len(self.students)}, Students List: {self.students}"


class StudentSteam:
    def __init__(self, stream_number: int, groups: List[StudentGroup]):
        self.stream_number = stream_number
        self.groups = groups

    def __str__(self):
        return f"Stream Number: {self.stream_number}, Number of Groups: {len(self.groups)}, Groups: {self.groups}"

    def __iter__(self):
        return iter(self.groups)


# Пример использования

# Создание групп студентов
group1 = StudentGroup(1, ["John", "Alice"])
group2 = StudentGroup(2, ["Bob", "Charlie", "Eve"])
group3 = StudentGroup(3, ["Mike", "Sarah", "Emily"])

# Создание потока студентов
stream = StudentSteam(1, [group1, group2, group3])

# Вывод групп студентов на консоль
for group in stream:
    print(group)

# Сортировка групп студентов в потоке по количеству студентов
stream.groups.sort(key=lambda x: (len(x.students), x.group_id))

# Вывод отсортированных групп студентов на консоль
for group in stream:
    print(group)