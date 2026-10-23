package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.program_robot.State.INITIAL;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.State;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class program_robot {
    public enum State { INITIAL, DRIVE_FORWARD, LOWER_ARM, SENSOR_PRESSED, DRIVE_BACKWARDS}

    public enum State { INITIAL, DRIVE_FORWARD, LOWER_ARM, SENSOR_PRESSED, DRIVE_BACKWARDS}
    State currentState = INITIAL;
    ElapsedTime timer = new ElapsedTime();
    Servo arm_pivot;
    Servo clawServo;
    DistanceSensor dist;
    double cm = dist.getDistance(DistanceUnit.CM);
    DcMotor leftMotor;
    DcMotor rightMotor;
    private void setDrivePower(double p) {
        leftMotor.setPower(p);
        rightMotor.setPower(p);
    }
    switch(currentState) {
        case State.INITIAL:
            State currentState=State.DRIVE_FORWARD;
            break;
        case State.DRIVE_FORWARD:
            timer.reset();
            private void setDrivePower(double p) {
                leftMotor.setPower(p);
                rightMotor.setPower(p);
                p = 0.5;
            }
            if(timer.seconds() >= 4) {
                State currentState = State.LOWER_ARM;
                p = 0;
            }
            if(cm < 10) {
                p = 0;
            }
            break;
        case State.LOWER_ARM:
            arm_pivot.setPosition(0.2);
            State currentState = State.SENSOR_PRESSED;
            break;
        case State.SENSOR_PRESSED:
            clawServo.setPosition(0);
            State currentState = State.DRIVE_BACKWARDS;
            break;
        case State.DRIVE_BACKWARDS:
            timer.reset();
            private void setDrivePower(double p){
                leftMotor.setPower(p);
                rightMotor.setPower(p);
                p = -0.5;
            }
            if(timer.seconds() >= 6) {
                p = 0;
            }
            if(cm < 10) {
                p = 0;
            }
            break;
    }
}