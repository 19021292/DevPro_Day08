package com.example.devpro_android43_day06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ISave{
    TextView Clock, Date, tags, weeks, tags_text, weeks_text, type_text;
    Button Tune;
    View Type;
    SavePresenter savePresenter;
    Button btnSave;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Clock = findViewById(R.id.Clock);
        Clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSelection();
            }
        });

        Date = findViewById(R.id.Date);
        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateSelection();
            }
        });

        Type = findViewById(R.id.type);
        type_text = findViewById(R.id.type_text);
        Type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Family", "Work", "Friend"};
                boolean[] booleans = {false, true, false};
                final List<String> stringList = Arrays.asList(strings);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("");
                builder.setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        booleans[which] = isChecked;
                        String choice = stringList.get(which);
                        Toast.makeText(getBaseContext(), strings[which], Toast.LENGTH_LONG).show();
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < booleans.length; i++) {
                            boolean checked = booleans[i];
                            if (checked) {
                                type_text.setText(type_text.getText() + stringList.get(i));
                            }
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        tags = findViewById(R.id.tags);
        tags_text = findViewById(R.id.tags_text);
        tags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Family", "Game", "Android", "VTC", "Friends"};
                boolean[] booleans = {false, true, false, true, false};
                final List<String> stringList = Arrays.asList(strings);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("");
                builder.setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        booleans[which] = isChecked;
                        String choice = stringList.get(which);
                        Toast.makeText(getBaseContext(), strings[which], Toast.LENGTH_LONG).show();
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < booleans.length; i++) {
                            boolean checked = booleans[i];
                            if (checked) {
                                tags_text.setText(tags_text.getText() + stringList.get(i) + ", ");
                            }
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        weeks = findViewById(R.id.weeks);
        weeks_text = findViewById(R.id.weeks_text);
        weeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
                boolean[] booleans = {false, true, false, true, false, true, false};
                final List<String> stringList = Arrays.asList(strings);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("");
                builder.setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        booleans[which] = isChecked;
                        String choice = stringList.get(which);
                        Toast.makeText(getBaseContext(), strings[which], Toast.LENGTH_LONG).show();
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < booleans.length; i++) {
                            boolean checked = booleans[i];
                            if (checked) {
                                weeks_text.setText(weeks_text.getText() + stringList.get(i) + ", ");
                            }
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    Tune = findViewById(R.id.Tune);
    Tune.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
            MenuInflater menuInflater = popupMenu.getMenuInflater();
            menuInflater.inflate(R.menu.tune_menu,popupMenu.getMenu());
            MenuItem item = popupMenu.getMenu().findItem(R.id.mnDefaults);
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    String[] strings = {"Nexus Tune", "Winphone tune", "Peep tune", "Nokia tune", "Etc"};
                    boolean[] booleans = {false, true, false, true, false};
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("");
                    builder.setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            Toast.makeText(getBaseContext(), strings[which], Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return false;
                }
            });
            popupMenu.show();
        }
    });
    btnSave = findViewById(R.id.btnSave);
    savePresenter = new SavePresenter(this);
    btnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            androidx.appcompat.app.AlertDialog alertDialog=new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this)
                    .setTitle("Save")
                    .setMessage("Do you want to save this?")
                    .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            savePresenter.onSave(1);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            savePresenter.onSave(0);
                        }
                    })
                    .create();
            alertDialog.show();
        }
    });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater((this));
        menuInflater.inflate(R.menu.save_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnCancel:
                Toast.makeText(getBaseContext(),"Cancel Save",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    int lastSelectedHour = -1;
    int lastSelectedMinute = -1;
    private void timeSelection()  {
        if(this.lastSelectedHour == -1)  {
            final Calendar c = Calendar.getInstance();
            this.lastSelectedHour = c.get(Calendar.HOUR_OF_DAY);
            this.lastSelectedMinute = c.get(Calendar.MINUTE);
        }
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Clock.setText(hourOfDay + ":" + minute );
                lastSelectedHour = hourOfDay;
                lastSelectedMinute = minute;
            }
        };
        TimePickerDialog timePickerDialog = null;
            timePickerDialog = new TimePickerDialog(this, timeSetListener, lastSelectedHour, lastSelectedMinute, true);
        timePickerDialog.show();
    }

    int lastSelectedYear = -1;
    int lastSelectedMonth = -1 ;
    int lastSelectedDay = -1;
    private void dateSelection()  {
        if(this.lastSelectedYear == -1)  {
            final Calendar c = Calendar.getInstance();
            this.lastSelectedYear = c.get(Calendar.YEAR);
            this.lastSelectedMonth = c.get(Calendar.MONTH);
            this.lastSelectedDay = c.get(Calendar.DAY_OF_MONTH);
        }
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                lastSelectedYear = year;
                lastSelectedMonth = monthOfYear;
                lastSelectedDay= dayOfMonth;
            }
        };
        DatePickerDialog datePickerDialog = null;
        datePickerDialog = new DatePickerDialog(this, dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDay);
        datePickerDialog.show();
    }

    @Override
    public void onSaveSuccessful(String mess) {

    }

    @Override
    public void onSaveError(String mess) {

    }
}
