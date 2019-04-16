package cn.jerryshell.liveteaching.vm;

import cn.jerryshell.liveteaching.dao.CourseDao;
import cn.jerryshell.liveteaching.dao.MajorDao;
import cn.jerryshell.liveteaching.dao.TeacherDao;
import cn.jerryshell.liveteaching.model.Course;
import cn.jerryshell.liveteaching.model.Live;
import cn.jerryshell.liveteaching.model.Major;
import cn.jerryshell.liveteaching.model.Teacher;

import java.util.Date;

public class LiveViewModel {
    private String id;
    private Teacher teacher;
    private Course course;
    private Major major;
    private String name;
    private String grade;
    private Date date;
    private String startTime;
    private String length;

    public static LiveViewModel loadFromModel(Live live, TeacherDao teacherDao, CourseDao courseDao, MajorDao majorDao) {
        LiveViewModel liveViewModel = new LiveViewModel();
        liveViewModel.setId(live.getId());
        liveViewModel.setName(live.getName());
        liveViewModel.setGrade(live.getGrade());
        liveViewModel.setDate(live.getDate());
        liveViewModel.setStartTime(live.getStartTime());
        liveViewModel.setLength(live.getLength());

        Teacher teacher = teacherDao.findById(live.getTeacherId()).orElse(null);
        liveViewModel.setTeacher(teacher);

        Course course = courseDao.findById(live.getCourseId()).orElse(null);
        liveViewModel.setCourse(course);

        Major major = majorDao.findById(live.getMajorId()).orElse(null);
        liveViewModel.setMajor(major);
        return liveViewModel;
    }

    @Override
    public String toString() {
        return "LiveViewModel{" +
                "id='" + id + '\'' +
                ", teacher=" + teacher +
                ", course=" + course +
                ", major=" + major +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", date=" + date +
                ", startTime='" + startTime + '\'' +
                ", length='" + length + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
