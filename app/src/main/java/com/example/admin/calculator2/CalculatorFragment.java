package com.example.admin.calculator2;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorFragment extends Fragment implements View.OnClickListener {
    public static final int ADD = 1;
    public static final int SUB = 2;
    public static final int MULTI = 3;
    public static final int DIVISION = 4;
    public static final int DEFAULT = 0;
    public static final String KEY = "key";

    private View mRootView;

    private Button mBtnAC;
    private Button mBtnNegative;
    private Button mBtnDel;
    private Button mBtnDivision;
    private Button mBtnAdd;
    private Button mBtnSub;
    private Button mBtnMul;
    private Button mBtnEqual;
    private Button mBtnPoint;
    private Button mBtn_0;
    private Button mBtn_1;
    private Button mBtn_2;
    private Button mBtn_3;
    private Button mBtn_4;
    private Button mBtn_5;
    private Button mBtn_6;
    private Button mBtn_7;
    private Button mBtn_8;
    private Button mBtn_9;

    private TextView mTxtValue;

    private String mStrValue;
    private float mValue_1;
    private float mValue_2;
    private float mResult;
    private int mMath;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_calculator, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();
    }


    private void initializeComponents() {
        mBtn_0 = getActivity().findViewById(R.id.btn_0);
        mBtn_1 = getActivity().findViewById(R.id.btn_1);
        mBtn_2 = getActivity().findViewById(R.id.btn_2);
        mBtn_3 = getActivity().findViewById(R.id.btn_3);
        mBtn_4 = getActivity().findViewById(R.id.btn_4);
        mBtn_5 = getActivity().findViewById(R.id.btn_5);
        mBtn_6 = getActivity().findViewById(R.id.btn_6);
        mBtn_7 = getActivity().findViewById(R.id.btn_7);
        mBtn_8 = getActivity().findViewById(R.id.btn_8);
        mBtn_9 = getActivity().findViewById(R.id.btn_9);
        mBtnAC = getActivity().findViewById(R.id.btn_AC);
        mBtnAdd = getActivity().findViewById(R.id.btn_add);
        mBtnDivision = getActivity().findViewById(R.id.btn_divide);
        mBtnMul = getActivity().findViewById(R.id.btn_multi);
        mBtnSub = getActivity().findViewById(R.id.btn_sub);
        mBtnNegative = getActivity().findViewById(R.id.btn_negative);
        mBtnDel = getActivity().findViewById(R.id.btn_del);
        mBtnPoint = getActivity().findViewById(R.id.btn_point);
        mBtnEqual = getActivity().findViewById(R.id.btn_equal);

        mBtn_0.setOnClickListener(this);
        mBtn_1.setOnClickListener(this);
        mBtn_2.setOnClickListener(this);
        mBtn_3.setOnClickListener(this);
        mBtn_4.setOnClickListener(this);
        mBtn_5.setOnClickListener(this);
        mBtn_6.setOnClickListener(this);
        mBtn_7.setOnClickListener(this);
        mBtn_8.setOnClickListener(this);
        mBtn_9.setOnClickListener(this);
        mBtnAdd.setOnClickListener(this);
        mBtnAC.setOnClickListener(this);
        mBtnDivision.setOnClickListener(this);
        mBtnMul.setOnClickListener(this);
        mBtnNegative.setOnClickListener(this);
        mBtnDel.setOnClickListener(this);
        mBtnPoint.setOnClickListener(this);
        mBtnEqual.setOnClickListener(this);
        mBtnSub.setOnClickListener(this);

        mResult = Float.MAX_VALUE;
        mStrValue = "0";
        mTxtValue = getActivity().findViewById(R.id.txt_value);
        mTxtValue.setText(mStrValue);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                addNumber('0');
                break;

            case R.id.btn_1:
                addNumber('1');
                break;

            case R.id.btn_2:
                addNumber('2');
                break;

            case R.id.btn_3:
                addNumber('3');
                break;

            case R.id.btn_4:
                addNumber('4');
                break;

            case R.id.btn_5:
                addNumber('5');
                break;

            case R.id.btn_6:
                addNumber('6');
                break;

            case R.id.btn_7:
                addNumber('7');
                break;

            case R.id.btn_8:
                addNumber('8');
                break;

            case R.id.btn_9:
                addNumber('9');
                break;

            case R.id.btn_AC:
                clickAC();
                break;

            case R.id.btn_point:
//                addNumber('.');
                break;

            case R.id.btn_negative:

                break;

            case R.id.btn_del:
                del();
                break;

            case R.id.btn_add:
                equal();
                clickmMath(ADD);
                break;

            case R.id.btn_sub:
                equal();
                clickmMath(SUB);
                break;

            case R.id.btn_multi:
                equal();
                clickmMath(MULTI);
                break;

            case R.id.btn_divide:
                equal();
                clickmMath(DIVISION);
                break;

            case R.id.btn_equal:
                equal();
                break;

            default:
                break;
        }
    }

    private String DelFirstZero(String str) {
        if (str.length() > 0 && str.charAt(0) == '0') {
            str = str.substring(1, str.length());
        }
        return str;
    }

    private void addNumber(char number) {
        mStrValue = DelFirstZero(mStrValue);
        mStrValue += number;
        mTxtValue.setText(mStrValue);
    }

    public void clickAC() {
        mStrValue = "0";
        mValue_2 = 0;
        mValue_1 = 0;
        mResult = Float.MAX_VALUE;
        mTxtValue.setText(mStrValue);
    }

    private void del() {
        if (mStrValue.length() > 1) {
            mStrValue = mStrValue.substring(0, mStrValue.length() - 1);
            mTxtValue.setText(mStrValue);
        } else {
            mStrValue = "0";
            mTxtValue.setText(mStrValue);
        }
    }

    private void clickmMath(int namemMath) {
        mMath = namemMath;
        if (mStrValue.length() > 0) {
            mValue_1 = Integer.parseInt(mStrValue);
        }
        mStrValue = "";
    }

    private void equal() {
        switch (mMath) {
            case ADD:
                add();
                break;

            case SUB:
                sub();
                break;

            case MULTI:
                multi();
                break;

            case DIVISION:
                division();
                break;

            default:
                break;
        }
    }

    private void add() {
        if (!mStrValue.isEmpty()) {
            mValue_2 = Float.parseFloat(mStrValue);
            if (mResult == Float.MAX_VALUE) {
                mResult = mValue_1 + mValue_2;
            } else {
                mResult = mResult + mValue_2;
            }
            saveOldResult(mResult);
            mTxtValue.setText(delZeroAfterPoint(mResult + ""));
            mMath = DEFAULT;
            mStrValue = "";
        }
    }

    private void sub() {
        if (!mStrValue.isEmpty()) {
            mValue_2 = Float.parseFloat(mStrValue);
            if (mResult == Float.MAX_VALUE) {
                mResult = mValue_1 - mValue_2;
            } else {
                mResult = mResult - mValue_2;
            }
            saveOldResult(mResult);
            mTxtValue.setText(delZeroAfterPoint(mResult + ""));
            mMath = DEFAULT;
            mStrValue = "";
        }
    }

    private void multi() {
        if (!mStrValue.isEmpty()) {
            mValue_2 = Float.parseFloat(mStrValue);
            if (mResult == Float.MAX_VALUE) {
                mResult = mValue_1 * mValue_2;
            } else {
                mResult = mResult * mValue_2;
            }
            saveOldResult(mResult);
            mTxtValue.setText(delZeroAfterPoint(mResult + ""));
            mMath = DEFAULT;
            mStrValue = "";
        }
    }

    private void division() {
        if (!mStrValue.isEmpty()) {
            mValue_2 = Float.parseFloat(mStrValue);
            if (mResult == Float.MAX_VALUE) {
                mResult = mValue_1 / mValue_2;
            } else {
                mResult = mResult / mValue_2;
            }
            saveOldResult(mResult);
            mTxtValue.setText(delZeroAfterPoint(mResult + ""));
            mMath = DEFAULT;
            mStrValue = "";
        }
    }

    private String delZeroAfterPoint(String mResult) {
        int locationOfPoint = mResult.indexOf('.');
        String strAfterPoint = mResult.substring(locationOfPoint + 1, mResult.length());
        if (strAfterPoint.equals("0")) {
            mResult = mResult.substring(0, locationOfPoint);
        }
        return mResult;
    }

    private void saveOldResult(float result) {
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("OLD_RESULT", result);
        editor.commit();
    }

    public void getOldResult() {
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        float oldResult = sharedPreferences.getFloat("OLD_RESULT", 0);
        mTxtValue.setText(delZeroAfterPoint(oldResult + ""));
    }
}
