from fastapi import FastAPI
import re
import json
from pydantic import BaseModel

app = FastAPI()


class ReqType(BaseModel):
    day: str
    batch: str
    file: str


@app.post("/")
async def get_subject_data(req: ReqType):
    batch = req.batch
    day = req.day
    file = req.file

    day_map = []

    classes = {}
    with open(file) as f:
        data = json.load(f)

        for d in data:
            if d["Column1"] == day:
                day_map.append(d)

    for d in day_map:
        for x, y in d.items():
            _m = re.match(r"^.*?\(", y)
            if not _m:
                continue

            result = _m.group(0)[:-1]
            class_string = result.split(",")

            for i in class_string:
                if batch in i:
                    classes[x] = y
    to_return = [
        {"time": "9-9.50 AM", "subject_code": "", "room" : ""},
        {"time": "10-10.50 AM", "subject_code": "", "room" : ""},
        {"time": "11-11.50 AM", "subject_code": "", "room" : ""},
        {"time": "12-12.50 PM", "subject_code": "", "room" : ""},
        {"time": "1-1.50 PM", "subject_code": "", "room" : ""},
        {"time": "2-2.50 PM", "subject_code": "", "room" : ""},
        {"time": "3-3.50 PM", "subject_code": "", "room" : ""},
        {"time": "4-4.50 PM", "subject_code": "", "room" : ""}
    ]

    for x, y in classes.items():
        match_parentheses = re.search(r"\((.*?)\)", y)
        match_hyphen_slash = re.search(r"-(.*?)/", y)

        subject_code = match_parentheses.group(1) if match_parentheses else None
        room_no = match_hyphen_slash.group(1) if match_hyphen_slash else None

        for entry in to_return:
            if entry["time"] == x:
                entry["subject_code"] = f"{subject_code}" if subject_code else None
                entry["room"] = f"{room_no}" if room_no else None

    return to_return
