Android library to create Adapters for RecyclerViews without adding new files to the project.

## Installation

```groovy
implementation 'es.alesagal:recycleradapter:1.0.1'
```


## Example

Creating the adapter.

```kotlin
mAdapter = object : RecyclerAdapter<ViewHolderImpl>(mList, R.layout.row, ViewHolderImpl::class.java) {
            override fun onBindViewHolder(viewHolder: ViewHolderImpl, position: Int) {
                viewHolder.lblText.text = mList[position]

                viewHolder.view.setOnClickListener {
                    mList.add(position.toString())
                    notifyItemInserted(mList.size - 1)
                }
            }
        }
```


Creating an instance of the ViewHolder

```kotlin
class ViewHolderImpl(val view: View) : RecyclerView.ViewHolder(view) {
        val lblText = view.findViewById<TextView>(R.id.lblText)!!
    }

```

That's it.