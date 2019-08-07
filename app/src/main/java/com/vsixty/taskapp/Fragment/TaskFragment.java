package com.vsixty.taskapp.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.vsixty.taskapp.API.Model.CommonModel;
import com.vsixty.taskapp.Activity.AddPeopeleActivity;
import com.vsixty.taskapp.Activity.AddTaskTitleActivity;
import com.vsixty.taskapp.Activity.AddWorkActivity;
import com.vsixty.taskapp.Activity.TicketActivity;
import com.vsixty.taskapp.Connect.Utilies;
import com.vsixty.taskapp.MainActivity;
import com.vsixty.taskapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TaskFragment extends Fragment {
    BottomSheetDialog bottomSheetDialog;
    RelativeLayout rlTodayLayout, rlTask, rlAddPeopleLayout, rlAddWorkLayout, rlTicket, rlAttachment, rlAddReminderLayout;
    ImageView rlTodayClick;
    TextView tvTodayTag, tvText;
    int res;
    String strIntent;
    Dialog dialog;
    RelativeLayout rlOneTimeLayout, rlRepeatLayout, rlDailyLayout, rlWeeklyLayout, rlMonthlyLayout;
    Button btOneTime, btRepeat;
    Dialog AddReminderDailog;
    TextView tvDate, tvTime, tvDaily, tvWeekly, tvMonthly, tvYearly, tvMonday1, tvTuesday1, tvWednesday1, tvThursday1, tvFriday1, tvSaturday1, tvSunday1, tvMonday2, tvTuesday2, tvWednesday2,
            tvThursday2, tvFriday2, tvSaturday2, tvSunday2, tvWeek1, tvWeek2, tvWeek3, tvWeek4, tvWeek5,
            tv30min, tvOneHours, tvTwoHours, tvFourHours, tvTenHours, tvnineclock, tv12clock, tv15clock,
            tv18clock, tv20clock, tvStartsOndate, tvStartsOntime, tvDateofMonth,tvNumber,tvAddReminder,tvAddPeople,tvAddWork,tvAddTicket,tvAttachment;
    Spinner spRepeatEveryDays, spRepeatMonth, spDayofWeek, spDate;
    Button btCancel, btSave;
    ArrayList<CommonModel> commonModels = new ArrayList<>();
    ArrayList<CommonModel> daysmodels = new ArrayList<>();
    ArrayList<CommonModel> monthmodels = new ArrayList<>();
    ArrayList<String> strDays = new ArrayList<>();
    ArrayList<String> strMonths = new ArrayList<>();
    ArrayList<String> strDayofweek = new ArrayList<>();
    String strDayofweekId, strDaysId, strMonthsId;
    ArrayAdapter DaysAdapter, MonthAdapter, DayofWeekAdapter;
    String thirtyminutes,onehour,twohour,fourhour,tenhour;
    int qty = 0;
    RelativeLayout rlTicketLayout,rlAttachmentLayout;
    Button  btIncrease, btDecrease;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {


        strIntent = getActivity().getIntent().getStringExtra("TITLE");


        rlTodayLayout = view.findViewById(R.id.rlTodayLayout);
        rlTodayClick = view.findViewById(R.id.rlTodayClick);
        tvTodayTag = view.findViewById(R.id.tvTodayTag);
        tvText = view.findViewById(R.id.tvText);

        tvText.setText(strIntent);
        rlTask = view.findViewById(R.id.rlTask);


        // add data into common models

        CommonModel Monday = new CommonModel();
        Monday.setId("1");
        Monday.setName("Monday");
        commonModels.add(Monday);


        CommonModel Tuesday = new CommonModel();
        Tuesday.setId("2");
        Tuesday.setName("Tuesday");
        commonModels.add(Tuesday);

        CommonModel Wednesday = new CommonModel();
        Wednesday.setId("3");
        Wednesday.setName("Wednesday");
        commonModels.add(Wednesday);

        CommonModel Thursday = new CommonModel();
        Thursday.setId("4");
        Thursday.setName("Thursday");
        commonModels.add(Thursday);

        CommonModel Friday = new CommonModel();
        Friday.setId("5");
        Friday.setName("Friday");
        commonModels.add(Friday);

        CommonModel Saturday = new CommonModel();
        Saturday.setId("6");
        Saturday.setName("Saturday");
        commonModels.add(Saturday);


        CommonModel Sunday = new CommonModel();
        Sunday.setId("7");
        Sunday.setName("Sunday");
        commonModels.add(Sunday);

        System.out.println("Day of Week ---" + commonModels.size());

        for (int i = 0; i < commonModels.size(); i++) {
            strDayofweek.add(commonModels.get(i).getName());
        }


        for (int i = 1; i <= 31; i++) {
            strDays.add(String.valueOf(i) + "Day");
        }


        CommonModel January = new CommonModel();
        January.setId("1");
        January.setName("January");
        monthmodels.add(January);


        CommonModel February = new CommonModel();
        February.setId("2");
        February.setName("February");
        monthmodels.add(February);


        CommonModel March = new CommonModel();
        March.setId("3");
        March.setName("March");
        monthmodels.add(March);


        CommonModel April = new CommonModel();
        April.setId("4");
        April.setName("April");
        monthmodels.add(April);


        CommonModel May = new CommonModel();
        May.setId("5");
        May.setName("May");
        monthmodels.add(May);


        CommonModel June = new CommonModel();
        June.setId("6");
        June.setName("June");
        monthmodels.add(June);


        CommonModel July = new CommonModel();
        July.setId("7");
        July.setName("July");
        monthmodels.add(July);


        CommonModel August = new CommonModel();
        August.setId("8");
        August.setName("August");
        monthmodels.add(August);


        CommonModel September = new CommonModel();
        September.setId("9");
        September.setName("September");
        monthmodels.add(September);


        CommonModel October = new CommonModel();
        October.setId("10");
        October.setName("October");
        monthmodels.add(October);


        CommonModel November = new CommonModel();
        November.setId("11");
        November.setName("November");
        monthmodels.add(November);


        CommonModel December = new CommonModel();
        December.setId("12");
        December.setName("December");
        monthmodels.add(December);


        for (int i = 0; i < monthmodels.size(); i++) {

            strMonths.add(monthmodels.get(i).getName());

        }

        tvTodayTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (tvText.getText().length() > 0) {
                    rlTask.setVisibility(View.VISIBLE);
                } else {
                    rlTask.setVisibility(View.GONE);
                }

            }
        });

        rlTodayClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), AddTaskTitleActivity.class);
                startActivity(intent);


            }
        });

        rlTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                bottomSheetDialog = new BottomSheetDialog(getActivity());
                bottomSheetDialog.setContentView(R.layout.sample);
                bottomSheetDialog.setCanceledOnTouchOutside(false);
                bottomSheetDialog.show();

                rlAddPeopleLayout = bottomSheetDialog.findViewById(R.id.rlAddPeopleLayout);
                rlAddWorkLayout = bottomSheetDialog.findViewById(R.id.rlAddWorkLayout);
                rlTicketLayout = bottomSheetDialog.findViewById(R.id.rlTicketLayout);
                rlAttachmentLayout = bottomSheetDialog.findViewById(R.id.rlAttachmentLayout);
                tvAddReminder = bottomSheetDialog.findViewById(R.id.tvAddReminder);
                tvAddPeople = bottomSheetDialog.findViewById(R.id.tvAddPeople);
                tvAddWork = bottomSheetDialog.findViewById(R.id.tvAddWork);
                tvAddTicket = bottomSheetDialog.findViewById(R.id.tvAddTicket);
                tvAttachment = bottomSheetDialog.findViewById(R.id.tvAttachment);
                rlAddReminderLayout = bottomSheetDialog.findViewById(R.id.rlAddReminderLayout);
                rlAddPeopleLayout = bottomSheetDialog.findViewById(R.id.rlAddPeopleLayout);
                rlAddWorkLayout = bottomSheetDialog.findViewById(R.id.rlAddWorkLayout);

                rlAddPeopleLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rlAddPeopleLayout.setBackground(getResources().getDrawable(R.drawable.layout_outline_selected_bg));
                        tvAddPeople.setTextColor(getResources().getColor(R.color.colorBlue));
                    }
                });

                rlAddWorkLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rlAddWorkLayout.setBackground(getResources().getDrawable(R.drawable.layout_outline_selected_bg));
                        tvAddWork.setTextColor(getResources().getColor(R.color.colorBlue));
                    }
                });
                rlTicketLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rlTicketLayout.setBackground(getResources().getDrawable(R.drawable.layout_outline_selected_bg));
                        tvAddTicket.setTextColor(getResources().getColor(R.color.colorBlue));
                    }
                });
                rlAttachmentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rlAttachmentLayout.setBackground(getResources().getDrawable(R.drawable.layout_outline_selected_bg));
                        tvAttachment.setTextColor(getResources().getColor(R.color.colorBlue));
                    }
                });

                View view1 = bottomSheetDialog.findViewById(R.id.View);
                view1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        bottomSheetDialog.dismiss();
                    }
                });
                rlAddReminderLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        rlAddReminderLayout.setBackground(getResources().getDrawable(R.drawable.layout_outline_selected_bg));
                        tvAddReminder.setTextColor(getResources().getColor(R.color.colorBlue));

                        CallAddReminder();
                    }
                });
                rlAddPeopleLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getActivity(), AddPeopeleActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
                rlAddWorkLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                        OpenAddWorkDialog();

                    }
                });
                rlAttachmentLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, 1);
                    }
                });

                rlTicketLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getActivity(), TicketActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });


            }
        });

    }

    private void CallAddReminder() {


        AddReminderDailog = new Dialog(getActivity());
        AddReminderDailog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AddReminderDailog.setContentView(R.layout.reminder_dialog);
        AddReminderDailog.setCanceledOnTouchOutside(false);
        AddReminderDailog.show();
        tvNumber = AddReminderDailog.findViewById(R.id.tvNumber);
        btDecrease = AddReminderDailog.findViewById(R.id.btDecrease);
        btDecrease.setClickable(false);
        btIncrease = AddReminderDailog.findViewById(R.id.btIncrease);
        btOneTime = AddReminderDailog.findViewById(R.id.btOneTime);
        btRepeat = AddReminderDailog.findViewById(R.id.btRepeat);
        rlOneTimeLayout = AddReminderDailog.findViewById(R.id.rlOneTimeLayout);
        rlRepeatLayout = AddReminderDailog.findViewById(R.id.rlRepeatLayout);
        rlDailyLayout = AddReminderDailog.findViewById(R.id.rlDailyLayout);
        rlWeeklyLayout = AddReminderDailog.findViewById(R.id.rlWeeklyLayout);
        rlMonthlyLayout = AddReminderDailog.findViewById(R.id.rlMonthlyLayout);
        tvDate = AddReminderDailog.findViewById(R.id.tvDate);
        tvTime = AddReminderDailog.findViewById(R.id.tvTime);
        tvDaily = AddReminderDailog.findViewById(R.id.tvDaily);
        tvWeekly = AddReminderDailog.findViewById(R.id.tvWeekly);
        tvMonthly = AddReminderDailog.findViewById(R.id.tvMonthly);
        tvYearly = AddReminderDailog.findViewById(R.id.tvYearly);
        tvMonday1 = AddReminderDailog.findViewById(R.id.tvMonday1);
        tvTuesday1 = AddReminderDailog.findViewById(R.id.tvTuesday1);
        tvWednesday1 = AddReminderDailog.findViewById(R.id.tvWednesday1);
        tvThursday1 = AddReminderDailog.findViewById(R.id.tvThursday1);
        tvFriday1 = AddReminderDailog.findViewById(R.id.tvFriday1);
        tvSaturday1 = AddReminderDailog.findViewById(R.id.tvSaturday1);
        tvSunday1 = AddReminderDailog.findViewById(R.id.tvSunday1);
        tvMonday2 = AddReminderDailog.findViewById(R.id.tvMonday2);
        tvTuesday2 = AddReminderDailog.findViewById(R.id.tvTuesday2);
        tvWednesday2 = AddReminderDailog.findViewById(R.id.tvWednesday2);
        tvThursday2 = AddReminderDailog.findViewById(R.id.tvThursday2);
        tvFriday2 = AddReminderDailog.findViewById(R.id.tvFriday2);
        tvSaturday2 = AddReminderDailog.findViewById(R.id.tvSaturday2);
        tvSunday2 = AddReminderDailog.findViewById(R.id.tvSunday2);
        tvWeek1 = AddReminderDailog.findViewById(R.id.tvWeek1);
        tvWeek2 = AddReminderDailog.findViewById(R.id.tvWeek2);
        tvWeek3 = AddReminderDailog.findViewById(R.id.tvWeek3);
        tvWeek4 = AddReminderDailog.findViewById(R.id.tvWeek4);
        tvWeek5 = AddReminderDailog.findViewById(R.id.tvWeek5);
        tv30min = AddReminderDailog.findViewById(R.id.tv30min);
        tvOneHours = AddReminderDailog.findViewById(R.id.tvOneHours);
        tvTwoHours = AddReminderDailog.findViewById(R.id.tvTwoHours);
        tvFourHours = AddReminderDailog.findViewById(R.id.tvFourHours);
        tvTenHours = AddReminderDailog.findViewById(R.id.tvTenHours);
        tvnineclock = AddReminderDailog.findViewById(R.id.tvnineclock);
        tv12clock = AddReminderDailog.findViewById(R.id.tv12clock);
        tv15clock = AddReminderDailog.findViewById(R.id.tv15clock);
        tv18clock = AddReminderDailog.findViewById(R.id.tv18clock);
        tv20clock = AddReminderDailog.findViewById(R.id.tv20clock);
        btSave = AddReminderDailog.findViewById(R.id.btSave);
        btCancel = AddReminderDailog.findViewById(R.id.btCancel);
        tvDateofMonth = AddReminderDailog.findViewById(R.id.tvDateofMonth);

        spRepeatEveryDays = AddReminderDailog.findViewById(R.id.spRepeatEveryDays);
        spRepeatMonth = AddReminderDailog.findViewById(R.id.spRepeatMonth);
        spDayofWeek = AddReminderDailog.findViewById(R.id.spDayofWeek);
        spDate = AddReminderDailog.findViewById(R.id.spDate);
        tvStartsOndate = AddReminderDailog.findViewById(R.id.tvStartsOndate);
        tvStartsOntime = AddReminderDailog.findViewById(R.id.tvStartsOntime);


        System.out.println("get data--" + strDayofweek.size());

        DaysAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item, strDays);
        DaysAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spRepeatEveryDays.setAdapter(DaysAdapter);

        DaysAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item, strDays);
        DaysAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spDate.setAdapter(DaysAdapter);

        DayofWeekAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item, strDayofweek);
        DayofWeekAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spDayofWeek.setAdapter(DayofWeekAdapter);


        MonthAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item, strMonths);
        MonthAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spRepeatMonth.setAdapter(MonthAdapter);


        tvDate.setText(Utilies.getCurrentDate());
        tvDateofMonth.setText(Utilies.getCurrentDate());
        tvTime.setText(Utilies.getCurrentTime());
        tvStartsOndate.setText(Utilies.getCurrentDate());
        tvStartsOntime.setText(Utilies.getCurrentTime());


        btOneTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlOneTimeLayout.setVisibility(View.VISIBLE);
                rlRepeatLayout.setVisibility(View.INVISIBLE);
                tvTime.setText(Utilies.getCurrentTime());
                btOneTime.setBackground(getResources().getDrawable(R.drawable.togglebutton_bg));
                btRepeat.setBackground(getResources().getDrawable(R.drawable.togglebutton_layout_bg));
                btOneTime.setTextColor(Color.parseColor("#ffffff"));
                btRepeat.setTextColor(Color.parseColor("#000000"));
                tvTime.setTextColor(getResources().getColor(R.color.colorblack));
                tvDate.setTextColor(getResources().getColor(R.color.colorblack));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_in);
                btOneTime.startAnimation(anim);
            }
        });


        btRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rlOneTimeLayout.setVisibility(View.INVISIBLE);
                rlRepeatLayout.setVisibility(View.VISIBLE);


                btRepeat.setBackground(getResources().getDrawable(R.drawable.togglebutton_bg));
                btOneTime.setBackground(getResources().getDrawable(R.drawable.togglebutton_layout_bg));

                btOneTime.setTextColor(Color.parseColor("#000000"));
                btRepeat.setTextColor(Color.parseColor("#ffffff"));

                Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_in);
                btRepeat.startAnimation(anim);
            }
        });


        tvDateofMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                tvStartsOntime.setVisibility(View.VISIBLE);
                tvStartsOntime.setAlpha(0.3f);
                final Calendar c = Calendar.getInstance();
                int myear = c.get(Calendar.YEAR);
                int mmonth = c.get(Calendar.MONTH);
                int mday = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.CalendarDatePickerDialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvDateofMonth.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                            }
                        }, myear, mmonth, mday);
                datePickerDialog.show();


            }
        });


        tvStartsOndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                tvStartsOntime.setVisibility(View.VISIBLE);
                tvStartsOntime.setAlpha(0.3f);
                final Calendar c = Calendar.getInstance();
                int myear = c.get(Calendar.YEAR);
                int mmonth = c.get(Calendar.MONTH);
                int mday = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.CalendarDatePickerDialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvStartsOndate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                            }
                        }, myear, mmonth, mday);
                datePickerDialog.show();


            }
        });

        tvStartsOntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvStartsOntime.setAlpha(0.8f);
                final Calendar ct = Calendar.getInstance();
                int mHour = ct.get(Calendar.HOUR_OF_DAY);
                int mMinute = ct.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), R.style.CalendarDatePickerDialog,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {


                                tvStartsOntime.setText(hourOfDay + ":" + minute);


                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });


        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int myear = c.get(Calendar.YEAR);
                int mmonth = c.get(Calendar.MONTH);
                int mday = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), R.style.CalendarDatePickerDialog,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                            }
                        }, myear, mmonth, mday);
                datePickerDialog.show();
                tvDate.setTextColor(getActivity().getResources().getColor(R.color.colorBlue));
            }
        });


        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), R.style.CalendarDatePickerDialog,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {


                                tvTime.setText(hourOfDay + ":" + minute);


                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();

                tvTime.setTextColor(getActivity().getResources().getColor(R.color.colorBlue));
            }
        });


        tvDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDaily.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvDaily.setTextColor(getResources().getColor(R.color.colorBlue));
                tvMonthly.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvMonthly.setTextColor(getResources().getColor(R.color.colorBlack));
                tvWeekly.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeekly.setTextColor(getResources().getColor(R.color.colorBlack));
                rlDailyLayout.setVisibility(View.VISIBLE);
                rlWeeklyLayout.setVisibility(View.GONE);
                rlMonthlyLayout.setVisibility(View.GONE);
            }
        });


        tvWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                tvWeekly.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvWeekly.setTextColor(getResources().getColor(R.color.colorBlue));
                tvMonthly.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvMonthly.setTextColor(getResources().getColor(R.color.colorBlack));
                tvDaily.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvDaily.setTextColor(getResources().getColor(R.color.colorBlack));
                tvMonday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTuesday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWednesday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvThursday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFriday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSaturday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSunday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));

                rlDailyLayout.setVisibility(View.GONE);
                rlWeeklyLayout.setVisibility(View.VISIBLE);
                rlMonthlyLayout.setVisibility(View.GONE);
            }
        });

        tvMonthly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvDaily.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvDaily.setTextColor(getResources().getColor(R.color.colorBlack));
                tvWeekly.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeekly.setTextColor(getResources().getColor(R.color.colorBlack));
                tvMonthly.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvMonthly.setTextColor(getResources().getColor(R.color.colorBlue));
                tvMonday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTuesday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWednesday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvThursday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFriday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSaturday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSunday1.setBackground(getResources().getDrawable(R.drawable.hour_bg));

                rlDailyLayout.setVisibility(View.GONE);
                rlWeeklyLayout.setVisibility(View.GONE);
                rlMonthlyLayout.setVisibility(View.VISIBLE);
            }
        });

        tv30min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("");
                Calendar c = Calendar.getInstance();
                DateFormat df = new SimpleDateFormat("HH:mm");
                c.add(Calendar.MINUTE, 30);
                Date d = c.getTime();
                thirtyminutes = df.format(d);
                tvTime.setText(thirtyminutes);

                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));

                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });
        tvOneHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvTime.setText("");
                Calendar c = Calendar.getInstance();
                DateFormat df = new SimpleDateFormat("HH:mm");
                c.add(Calendar.HOUR,1);
                Date d = c.getTime();
                onehour = df.format(d);
                tvTime.setText(onehour);
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));


                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });

        tvTwoHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvTime.setText("");
                Calendar c = Calendar.getInstance();
                DateFormat df = new SimpleDateFormat("HH:mm");
                c.add(Calendar.HOUR,2);
                Date d = c.getTime();
                twohour = df.format(d);
                tvTime.setText(twohour);
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));


                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });

        tvFourHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                tvTime.setText("");
                Calendar c = Calendar.getInstance();
                DateFormat df = new SimpleDateFormat("HH:mm");
                c.add(Calendar.HOUR,4);
                Date d = c.getTime();
                fourhour = df.format(d);
                tvTime.setText(fourhour);
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));


                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });

        tvTenHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvTime.setText("");
                Calendar c = Calendar.getInstance();
                DateFormat df = new SimpleDateFormat("HH:mm");
                c.add(Calendar.HOUR,10);
                Date d = c.getTime();
                tenhour = df.format(d);
                tvTime.setText(tenhour);
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));


                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });

        tvnineclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("");
                tvTime.setText("09:00");
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));

                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });

        tv12clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("");
                tvTime.setText("12:00");
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));

                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });
        tv15clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("");
                tvTime.setText("15:00");
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));

                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });

        tv18clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("");
                tvTime.setText("18:00");
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));

                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });


        tv20clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTime.setText("");
                tvTime.setText("18:00");
                tvTime.setTextColor(getResources().getColor(R.color.colorBlue));
                tvDate.setTextColor(getResources().getColor(R.color.colorBlue));


                tv20clock.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tv30min.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvOneHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTwoHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFourHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTenHours.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvnineclock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv12clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv15clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tv18clock.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });


       /* tv30min, tvOneHours, tvTwoHours, tvFourHours, tvTenHours, tvnineclock, tv12clock, tv15clock,
                tv18clock, tv20clock,
        */

        tvMonday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMonday1.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });

        tvTuesday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTuesday1.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });

        tvWednesday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWednesday1.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvThursday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvThursday1.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvFriday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFriday1.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvSaturday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSaturday1.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvSunday1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSunday1.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });

        tvMonday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMonday2.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });

        tvTuesday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTuesday2.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });

        tvWednesday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWednesday2.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvThursday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvThursday2.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvFriday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFriday2.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvSaturday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSaturday2.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvSunday2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSunday2.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
            }
        });
        tvWeek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWeek1.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvWeek2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek3.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek4.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek5.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvMonday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTuesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWednesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvThursday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFriday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSaturday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSunday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));

            }
        });

        tvWeek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWeek2.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvWeek1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek3.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek4.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek5.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvMonday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTuesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWednesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvThursday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFriday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSaturday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSunday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });

        tvWeek3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWeek3.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvWeek1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek4.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek5.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvMonday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTuesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWednesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvThursday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFriday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSaturday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSunday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });
        tvWeek4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWeek4.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvWeek1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek3.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek5.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvMonday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTuesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWednesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvThursday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFriday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSaturday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSunday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });
        tvWeek5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvWeek5.setBackground(getResources().getDrawable(R.drawable.hour_selected_bg));
                tvWeek1.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek3.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWeek4.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvMonday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvTuesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvWednesday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvThursday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvFriday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSaturday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
                tvSunday2.setBackground(getResources().getDrawable(R.drawable.hour_bg));
            }
        });


        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddReminderDailog.dismiss();

                rlAddReminderLayout.setBackground(getResources().getDrawable(R.drawable.layout_outline));
                tvAddReminder.setTextColor(getResources().getColor(R.color.colorblack));

            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "saved sucessfully", Toast.LENGTH_SHORT).show();
                AddReminderDailog.dismiss();
                rlAddReminderLayout.setBackground(getResources().getDrawable(R.drawable.layout_outline));
                tvAddReminder.setTextColor(getResources().getColor(R.color.colorblack));
            }
        });


        btDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                qty = qty - 1;
                display(qty);


            }
        });


        btIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btDecrease.setClickable(true);
                btDecrease.setVisibility(View.VISIBLE);


                qty = qty + 1;
                display(qty);


            }


        });



        tvNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (tvNumber.getText().toString().equalsIgnoreCase("0")) {

                    btDecrease.setClickable(false);


                } else {
                    btDecrease.setClickable(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });





    }

    private void display(int qty) {


        tvNumber.setText("" + qty);


    }
    private void OpenAddWorkDialog() {


        Intent intent = new Intent(getActivity(), AddWorkActivity.class);
        startActivity(intent);


    }




}
