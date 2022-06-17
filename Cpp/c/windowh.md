#### 視窗參考用
### https://www.youtube.com/watch?v=FXrulJXMiU8
```c
#include <windows.h>

LRESULT CALLBACK WindowProcedure (HWND , UINT , WPARAM , LPARAM);

char szClassName[] = "TextEntry";

char Text[20];
HWND TextBox;

int WINAPI WinMain ( HINSTANCE hInstance,
                                    HINSTANCE hPrevinstance,
                                    LPSTR lpszArgument,
                                    int nCmdShow )
{
    HWND hwnd;
    MSG messages;
    WNDCLASSEX wincl;

    wincl.hInstance = hInstance;
    wincl.lpszClassName = szClassName;
    wincl.lpfnWndProc = WindowProcedure;
    wincl.style = CS_DBLCLKS;
    wincl.cbSize = sizeof(WNDCLASSEX);

    wincl.hIcon = LoadIcon (NULL, IDI_APPLICATION);
    wincl.hIconSm = LoadIcon (NULL, IDI_APPLICATION);
    wincl.hCursor = LoadCursor (NULL, IDC_ARROW);
    wincl.lpszMenuName = NULL;
    wincl.cbClsExtra = 0;
    wincl.cbWndExtra = 0;

    wincl.hbrBackground = (HBRUSH) COLOR_BACKGROUND + 1;

    if (!RegisterClassEx(&wincl))
        return 0;

    hwnd = CreateWindowEx (
                                  0,
                                  szClassName,
                                  "Text Entry",
                                  WS_SYSMENU | WS_MINIMIZEBOX,
                                  CW_USEDEFAULT, CW_USEDEFAULT, 200, 200,
                                  HWND_DESKTOP,
                                  NULL,
                                  hInstance,
                                  NULL);

    ShowWindow (hwnd, nCmdShow);

    while (GetMessage (&messages, NULL, 0, 0))
    {
        TranslateMessage(&messages);
        DispatchMessage(&messages);
    }
    return messages.wParam;
}


LRESULT CALLBACK WindowProcedure(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    switch (message)
    {
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    // TextBox
    case WM_CREATE:
        TextBox = CreateWindow("EDIT", "123",
                                                WS_BORDER | WS_CHILD | WS_VISIBLE,
                                                10, 10, 100, 20,
                                                hwnd, NULL, NULL, NULL);
        CreateWindow("Button", "GO",
                                WS_VISIBLE | WS_CHILD | WS_BORDER,
                                120, 10, 50, 20,
                                hwnd, (HMENU) 1, NULL, NULL);
        break;
    case WM_COMMAND:
        switch (LOWORD(wParam))
        {
        case 1:
            GetWindowText(TextBox, Text, 20);
            MessageBox(NULL, Text, "message", MB_OK);
            break;
        }
        break;

    default:
        return DefWindowProc(hwnd, message, wParam, lParam);
    }
    return 0;
}

```
### https://home.gamer.com.tw/creationDetail.php?sn=3724093
```c
#define UNICODE
#include<windows.h>

LRESULT CALLBACK WndProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam);

HWND TextBox;

int main()
{
    WNDCLASS wndclass;
    ZeroMemory(&wndclass, sizeof(WNDCLASS));
    wndclass.style = CS_HREDRAW | CS_VREDRAW;
    wndclass.lpfnWndProc = WndProc;
    wndclass.hCursor = LoadCursor(NULL, IDC_ARROW);
    wndclass.hbrBackground = (HBRUSH)(COLOR_BTNFACE+1);
    wndclass.lpszClassName = L"window";
    RegisterClass(&wndclass);

    HWND window = CreateWindow(
                               L"window", L"title",
                               WS_OVERLAPPED | WS_SYSMENU | WS_VISIBLE,
                               CW_USEDEFAULT, CW_USEDEFAULT, 200, 200,
                               NULL, NULL, NULL, NULL);

    MSG msg;
    int ret;
    for(;;)
    {
        ret = GetMessage(&msg, NULL, 0, 0);
        if(ret <= 0)
            break;

        DispatchMessage(&msg);
    }

    return 0;
}

LRESULT CALLBACK WndProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    switch(message)
    {
    case WM_DESTROY:
        PostQuitMessage(0);
        break;
    // TextBox
    case WM_CREATE:
        TextBox = CreateWindow(
                               L"EDIT", L"123",
                               WS_BORDER | WS_CHILD | WS_VISIBLE,
                               10, 10, 100, 20,
                               hwnd, NULL, NULL, NULL);
        break;
    case WM_COMMAND:
        switch (LOWORD(wParam))
        {
        case 1:

            break;
        }
        break;
    }

    return DefWindowProc(hwnd,message,wParam,lParam);
}
```